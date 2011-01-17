/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime;

import java.util.Iterator;

import vitry.runtime.Vitry.Unit;

/**
 * Implements list types. This include products on the form `(a,(a,...()))`.
 * 
 * Provides efficient matching on {@link AbstractList} subclasses.
 */
public class ListType extends AbstractUnion
    {
        private final Pattern type;

        public ListType(Pattern type) {
            this.type = type;
        }

        public boolean match(Product a) {
            return (a instanceof AbstractList && ((AbstractList) a).type == this.type)
                    || super.match(a);
        }

        public Pattern head() {
            return Vitry.unit;
        }

        public Seq<Pattern> tail() {
            // TODO implement a proper lazy pair
            return new Seq<Pattern>()
                {

                    public Iterator<Pattern> iterator() {
                        return null;
                    }

                    public Pattern head() {
                        return new ConsType(type);
                    }

                    public Seq<Pattern> tail() {
                        return null;
                    }

                    public Seq<Pattern> cons(Pattern head) {
                        return null;
                        // TODO Auto-generated method stub
                    }
                };
        }

        public String toString() {
            return "[" + type + "]";
        }

        public Seq<Pattern> cons(Pattern head) {
            return null;
            // TODO Auto-generated method stub
        }
    }


class ConsType extends AbstractProduct
    {
        final Pattern type;

        public ConsType(Pattern type) {
            this.type = type;
        }

        public Pattern head() {
            return type;
        }

        public Seq<Pattern> tail() {
            return new Seq<Pattern>()
                {
                    public Iterator<Pattern> iterator() {
                        return null;
                    }

                    public Pattern head() {
                        return new ListType(type);
                    }

                    public Seq<Pattern> tail() {
                        return null;
                    }

                    public Seq<Pattern> cons(Pattern head) {
                        return null;
                        // TODO Auto-generated method stub
                    }
                };
        }

        public Product first() {
            return null;
            // TODO Auto-generated method stub
        }

        public Product second() {
            return null;
            // TODO Auto-generated method stub
        }

        public Seq<Pattern> cons(Pattern head) {
            return null;
            // TODO Auto-generated method stub
        }
    }