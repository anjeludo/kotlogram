package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLFound;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestContactsSearch extends TLMethod<TLFound> {
    public static final int CLASS_ID = 0x11f812d8;

    protected String q;

    protected int limit;

    public TLRequestContactsSearch() {
    }

    public TLRequestContactsSearch(String q, int limit) {
        this.q = q;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLFound deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLFound)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLFound) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(q, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        q = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "contacts.search#11f812d8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
