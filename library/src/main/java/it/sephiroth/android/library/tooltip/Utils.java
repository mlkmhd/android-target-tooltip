package it.sephiroth.android.library.tooltip;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.util.Log.INFO;
import static android.util.Log.VERBOSE;
import static it.sephiroth.android.library.tooltip.Tooltip.DBG;

/**
 * Created by alessandro on 12/12/15.
 */
class Utils {

    @Nullable
    static Activity getActivity(@Nullable Context cont) {
        if (cont == null) {
            return null;
        } else if (cont instanceof Activity) {
            return (Activity) cont;
        } else if (cont instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) cont).getBaseContext());
        }
        return null;
    }

    static void log(final String tag, final int level, final String format, Object... args) {
        if (DBG) {
            switch (level) {
                case Log.DEBUG:
                    Log.d(tag, String.format(format, args));
                    break;
                case Log.ERROR:
                    Log.e(tag, String.format(format, args));
                    break;
                case INFO:
                    Log.i(tag, String.format(format, args));
                    break;
                case Log.WARN:
                    Log.w(tag, String.format(format, args));
                    break;
                default:
                case VERBOSE:
                    Log.v(tag, String.format(format, args));
                    break;
            }
        }
    }
}
