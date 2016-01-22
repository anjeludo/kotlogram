package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLAffectedHistory extends TLObject {
    public static final int CLASS_ID = 0xb45c69d1;

    protected int pts;

    protected int ptsCount;

    protected int offset;

    public TLAffectedHistory() {
    }

    public TLAffectedHistory(int pts, int ptsCount, int offset) {
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.offset = offset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(offset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        pts = readInt(stream);
        ptsCount = readInt(stream);
        offset = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.affectedHistory#b45c69d1";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
