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

import vitry.runtime.error.*;
import vitry.runtime.misc.*;


abstract public class AbstractEnv<K, V> implements Env<K, V>
{
    private static Env<?, ?> GLOBAL = new GlobalEnvironment();
    private final Env<K, V> parent;

    public AbstractEnv() {
        this.parent = AbstractEnv.<K, V> empty();
    }

    public AbstractEnv(Env<K, V> parent) {
        this.parent = parent;
    }

    public Env<K, V> getParent()
    {
        return parent;
    }

    public V lookup(K key) throws UndefinedError
    {
        Env<K, V> env = this;
        try
        {
            while (env != null)
            {
                if (env.hasBinding(key))
                {
                    return env.getBinding(key);
                }
                env = env.getParent();
            }
        } catch (UndefinedError e)
        {
            // Rethrow with this below
        }
        throw new UndefinedError(key, this);
    }

    public Env<K, V> assoc(K key, V val)
    {
        return throwUnsupported();
    }

    /**
     * Returns an persistent, empty environment. All operations except
     * hasBinding and isPersistent are unsupported.
     */
    public static <K, V> Env<K, V> empty()
    {
        return Utils.<Env<K, V>>unsafe(GLOBAL);
    }

    private <T> T throwUnsupported()
    {
        throw new UnsupportedOperationException();
    }
}


class GlobalEnvironment extends AbstractEnv<Object, Object>
{
    public Env<Object, Object> define(Object key, Object val) throws BindingError
    {
        return throwUnsupported();
    }

    public Env<Object, Object> extend(Object key, Object val)
    {
        return throwUnsupported();
    }

    public Env<Object, Object> extend()
    {
        return throwUnsupported();
    }

    public boolean isPersistent()
    {
        return true;
    }

    public boolean hasBinding(Object key)
    {
        return false;
    }

    public Object getBinding(Object key)
    {
        throw new UndefinedError(key, this); // TODO throw something lighter
    }

    private <T> T throwUnsupported()
    {
        throw new UnsupportedOperationException();
    }
}