package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsFoundGif;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLFoundGifs extends TLObject {
    public static final int CLASS_ID = 0x450a1c0a;

    protected int nextOffset;

    protected TLVector<TLAbsFoundGif> results;

    public TLFoundGifs() {
    }

    public TLFoundGifs(int nextOffset, TLVector<TLAbsFoundGif> results) {
        this.nextOffset = nextOffset;
        this.results = results;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(nextOffset, stream);
        writeTLVector(results, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        nextOffset = readInt(stream);
        results = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.foundGifs#450a1c0a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public TLVector<TLAbsFoundGif> getResults() {
        return results;
    }

    public void setResults(TLVector<TLAbsFoundGif> results) {
        this.results = results;
    }
}
