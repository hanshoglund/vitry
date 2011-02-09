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

/**
 * Represents the fixity of some operator.
 */
public class Fixity extends ProductAdaptor
    {
        private final Symbol operator;
        private final int precedence;
        private final boolean left;        
        
        public Fixity(Symbol operator, int precedence, boolean left) {
            this.operator = operator;
            this.precedence = precedence;
            this.left = left;
        }
        
        public Symbol getOperator() {
            return operator;
        }
        public int getPrecedence() {
            return precedence;
        }
        public boolean isLeft() {
            return left;
        }

        public Product asProduct() {
            return new SimpleProduct(operator, precedence, left);
        }
    }
