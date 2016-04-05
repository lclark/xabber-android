/**
 * Copyright (c) 2013, Redsolution LTD. All rights reserved.
 *
 * This file is part of Xabber project; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License, Version 3.
 *
 * Xabber is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * along with this program. If not, see http://www.gnu.org/licenses/.
 */
package com.xabber.android.data.entity;

import android.support.annotation.NonNull;

/**
 * Object with relation to the account.
 *
 * @author alexander.ivanov
 */
public abstract class AccountRelated {

    protected final @NonNull AccountJid account;

    public AccountRelated(@NonNull AccountJid account) {
        super();
        this.account = account;
    }

    @NonNull
    public AccountJid getAccount() {
        return account;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (account.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AccountRelated && this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountRelated)) {
            return false;
        }
        AccountRelated other = (AccountRelated) obj;
        return account.equals(other.account);
    }

}
