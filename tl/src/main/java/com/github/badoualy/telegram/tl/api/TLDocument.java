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
public class TLDocument extends TLAbsDocument {
    public static final int CLASS_ID = 0xf9a39f4f;

    protected long accessHash;

    protected int date;

    protected String mimeType;

    protected int size;

    protected TLAbsPhotoSize thumb;

    protected int dcId;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    public TLDocument() {
    }

    public TLDocument(long id, long accessHash, int date, String mimeType, int size, TLAbsPhotoSize thumb, int dcId, TLVector<TLAbsDocumentAttribute> attributes) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.mimeType = mimeType;
        this.size = size;
        this.thumb = thumb;
        this.dcId = dcId;
        this.attributes = attributes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeTLString(mimeType, stream);
        writeInt(size, stream);
        writeTLObject(thumb, stream);
        writeInt(dcId, stream);
        writeTLVector(attributes, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        mimeType = readTLString(stream);
        size = readInt(stream);
        thumb = (com.github.badoualy.telegram.tl.api.TLAbsPhotoSize) readTLObject(stream, context);
        dcId = readInt(stream);
        attributes = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "document#f9a39f4f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TLAbsPhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsPhotoSize thumb) {
        this.thumb = thumb;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
    }
}
