package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMessageText extends TLAbsBotInlineMessage {
    public static final int CLASS_ID = 0xa56197a9;

    protected int flags;

    protected boolean noWebpage;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    public TLBotInlineMessageText() {
    }

    public TLBotInlineMessageText(int flags, boolean noWebpage, String message, TLVector<TLAbsMessageEntity> entities) {
        this.flags = flags;
        this.noWebpage = noWebpage;
        this.message = message;
        this.entities = entities;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(noWebpage, stream);
        writeTLString(message, stream);
        if ((flags & 2) != 0) writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noWebpage = (flags & 1) != 0;
        message = readTLString(stream);
        if ((flags & 2) != 0) entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "botInlineMessageText#a56197a9";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean noWebpage) {
        this.noWebpage = noWebpage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
