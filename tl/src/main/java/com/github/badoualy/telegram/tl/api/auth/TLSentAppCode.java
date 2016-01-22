package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLSentAppCode extends TLAbsSentCode {
    public static final int CLASS_ID = 0xe325edcf;

    public TLSentAppCode() {
    }

    public TLSentAppCode(boolean phoneRegistered, String phoneCodeHash, int sendCallTimeout, boolean isPassword) {
        this.phoneRegistered = phoneRegistered;
        this.phoneCodeHash = phoneCodeHash;
        this.sendCallTimeout = sendCallTimeout;
        this.isPassword = isPassword;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBool(phoneRegistered, stream);
        writeTLString(phoneCodeHash, stream);
        writeInt(sendCallTimeout, stream);
        writeTLBool(isPassword, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneRegistered = readTLBool(stream);
        phoneCodeHash = readTLString(stream);
        sendCallTimeout = readInt(stream);
        isPassword = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "auth.sentAppCode#e325edcf";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public int getSendCallTimeout() {
        return sendCallTimeout;
    }

    public void setSendCallTimeout(int sendCallTimeout) {
        this.sendCallTimeout = sendCallTimeout;
    }

    public boolean getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(boolean isPassword) {
        this.isPassword = isPassword;
    }
}
