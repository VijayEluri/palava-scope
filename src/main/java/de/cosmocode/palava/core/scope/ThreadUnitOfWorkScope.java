/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package de.cosmocode.palava.core.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;


/**
 * A {@link ThreadLocal} based {@link UnitOfWorkScope} implementation.
 *
 * @author Willi Schoenborn
 */
public final class ThreadUnitOfWorkScope extends AbstractScope<ScopeContext> implements UnitOfWorkScope {

    private static final Logger LOG = LoggerFactory.getLogger(ThreadUnitOfWorkScope.class);
    
    private final ThreadLocal<ScopeContext> context = new ThreadLocal<ScopeContext>();
    
    @Override
    public void enter() {
        Preconditions.checkState(context.get() == null, "Scope already entered");
        LOG.trace("Entering {}", this);
        context.set(new SimpleScopeContext());
    }

    @Override
    public void exit() {
        Preconditions.checkState(context.get() != null, "No scope block in progress");
        LOG.trace("Exiting {}", this);
        context.remove();
    }

    @Override
    public ScopeContext get() {
        return context.get();
    }

}
