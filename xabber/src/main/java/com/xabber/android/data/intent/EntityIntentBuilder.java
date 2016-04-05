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
package com.xabber.android.data.intent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.xabber.android.data.LogManager;
import com.xabber.android.data.entity.UserJid;

import org.jxmpp.stringprep.XmppStringprepException;

/**
 * Intent builder with account and user fields.
 *
 * @author alexander.ivanov
 */
public class EntityIntentBuilder extends
        BaseAccountIntentBuilder<EntityIntentBuilder> {

    private static final String LOG_TAG = EntityIntentBuilder.class.getSimpleName();

    public EntityIntentBuilder(Context context, Class<?> cls) {
        super(context, cls);
    }

    private UserJid user;

    public EntityIntentBuilder setUser(UserJid user) {
        this.user = user;
        return this;
    }

    @Override
    void preBuild() {
        super.preBuild();
        if (user == null)
            return;
        if (getSegmentCount() == 0)
            throw new IllegalStateException();
        addSegment(user.toString());
    }

    @Nullable
    public static UserJid getUser(Intent intent) {
        String segment = getSegment(intent, 1);

        if (segment == null) {
            return null;
        }

        try {
            return UserJid.from(segment);
        } catch (XmppStringprepException e) {
            LogManager.exception(LOG_TAG, e);
            return null;
        }
    }

}