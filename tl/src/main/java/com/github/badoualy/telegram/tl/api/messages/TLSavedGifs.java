package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
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
public class TLSavedGifs extends TLAbsSavedGifs {
    public static final int CLASS_ID = 0x2e0709a5;

    protected int hash;

    protected TLVector<TLAbsDocument> gifs;

    public TLSavedGifs() {
    }

    public TLSavedGifs(int hash, TLVector<TLAbsDocument> gifs) {
        this.hash = hash;
        this.gifs = gifs;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(gifs, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        gifs = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.savedGifs#2e0709a5";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLAbsDocument> getGifs() {
        return gifs;
    }

    public void setGifs(TLVector<TLAbsDocument> gifs) {
        this.gifs = gifs;
    }
}
