package com.github.badoualy.telegram.mtproto.model

import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.core.TLObject
import org.slf4j.MarkerFactory
import java.math.BigInteger

/** see https://core.telegram.org/mtproto/description#session
a (random) 64-bit number generated by the client */
class MTSession(var dataCenter: DataCenter, var id: ByteArray = RandomUtils.randomSessionId(),
                var salt: Long = 0, var contentRelatedCount: Int = 0, var lastMessageId: Long = 0) {

    @Transient
    val idLong = BigInteger(id).toLong()
    @Transient
    val marker = MarkerFactory.getMarker(idLong.toString())

    /**
     * Generate a valid seqNo value for the given message type
     * @param clazz message type
     * @return a valid seqNo value to send
     * @see <a href="https://core.telegram.org/mtproto/description#message-sequence-number-msg-seqno">MTProto description</a>
     */
    fun generateSeqNo(clazz: Class<out TLObject>) = generateSeqNo(TLObjectUtils.isContentRelated(clazz))

    private fun generateSeqNo(contentRelated: Boolean): Int {
        var seqNo = -1
        synchronized(this) {
            seqNo = if (contentRelated) {
                seqNo = contentRelatedCount * 2 + 1
                contentRelatedCount++
                seqNo
            } else {
                contentRelatedCount * 2
            }
        }
        return seqNo
    }


    fun generateSeqNo(message: TLObject) = generateSeqNo(message.javaClass)

    fun generateMessageId(): Long {
        val weakMessageId = TimeOverlord.generateMessageId(dataCenter)
        synchronized(this) {
            lastMessageId = Math.max(weakMessageId, lastMessageId + 4)
        }
        return lastMessageId
    }
}