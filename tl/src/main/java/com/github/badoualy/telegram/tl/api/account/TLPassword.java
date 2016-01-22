package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLPassword extends TLAbsPassword {
    public static final int CLASS_ID = 0x7c18141c;

    protected TLBytes currentSalt;

    protected TLBytes newSalt;

    protected String hint;

    protected boolean hasRecovery;

    protected String emailUnconfirmedPattern;

    public TLPassword() {
    }

    public TLPassword(TLBytes currentSalt, TLBytes newSalt, String hint, boolean hasRecovery, String emailUnconfirmedPattern) {
        this.currentSalt = currentSalt;
        this.newSalt = newSalt;
        this.hint = hint;
        this.hasRecovery = hasRecovery;
        this.emailUnconfirmedPattern = emailUnconfirmedPattern;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(currentSalt, stream);
        writeTLBytes(newSalt, stream);
        writeTLString(hint, stream);
        writeTLBool(hasRecovery, stream);
        writeTLString(emailUnconfirmedPattern, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        currentSalt = readTLBytes(stream, context);
        newSalt = readTLBytes(stream, context);
        hint = readTLString(stream);
        hasRecovery = readTLBool(stream);
        emailUnconfirmedPattern = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.password#7c18141c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLBytes getCurrentSalt() {
        return currentSalt;
    }

    public void setCurrentSalt(TLBytes currentSalt) {
        this.currentSalt = currentSalt;
    }

    public TLBytes getNewSalt() {
        return newSalt;
    }

    public void setNewSalt(TLBytes newSalt) {
        this.newSalt = newSalt;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean getHasRecovery() {
        return hasRecovery;
    }

    public void setHasRecovery(boolean hasRecovery) {
        this.hasRecovery = hasRecovery;
    }

    public String getEmailUnconfirmedPattern() {
        return emailUnconfirmedPattern;
    }

    public void setEmailUnconfirmedPattern(String emailUnconfirmedPattern) {
        this.emailUnconfirmedPattern = emailUnconfirmedPattern;
    }
}
