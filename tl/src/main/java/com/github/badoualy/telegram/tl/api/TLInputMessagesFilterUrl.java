package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterUrl extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x7ef0dd87;

    public TLInputMessagesFilterUrl() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterUrl#7ef0dd87";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
