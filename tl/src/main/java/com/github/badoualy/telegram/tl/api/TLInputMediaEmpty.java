package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaEmpty extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x9664f57f;

    public TLInputMediaEmpty() {
    }

    @Override
    public String toString() {
        return "inputMediaEmpty#9664f57f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
