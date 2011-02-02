package vitry.runtime.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vitry.runtime.Symbol;
import vitry.runtime.struct.IterableSequence;


public class TestIterableSeq
    {

        static IterableSequence<Symbol> seq;

        static Symbol a = Symbol.intern("a"), b = Symbol.intern("b");

        @Before
        public void setUp() throws Exception {
            List<Symbol> l = new java.util.ArrayList<Symbol>();
            l.add(a);
            l.add(b);
            seq = new IterableSequence<Symbol>(l);
        }

        @Test
        public void testIterator() {
            Iterator<Symbol> it = seq.iterator();
            assertEquals ( it.next()     , a );
            assertEquals ( it.next()     , b );
            assertTrue   ( !it.hasNext()     );
        }

        @Test
        public void testHead() {
            assertEquals ( seq.head()        , a );
            assertEquals ( seq.tail().head() , b );
            assertEquals ( seq.tail().head() , b );
        }

    }
