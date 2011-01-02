package vitry.primitive;

import java.util.Iterator;


/**
 * Implement:
 *   - Provide match and matchedBy
 *   - Provide head and tail
 */
public abstract class AbstractPattern implements Pattern
    {
        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
    }
