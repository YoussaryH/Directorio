// Generated code from Butter Knife. Do not modify!
package com.example.yhernandez.directorio.Controller;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.yhernandez.directorio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListFilmsActivity_ViewBinding implements Unbinder {
  private ListFilmsActivity target;

  @UiThread
  public ListFilmsActivity_ViewBinding(ListFilmsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListFilmsActivity_ViewBinding(ListFilmsActivity target, View source) {
    this.target = target;

    target.rvListFilms = Utils.findRequiredViewAsType(source, R.id.rvListFilms, "field 'rvListFilms'", RecyclerView.class);
    target.disconnected = Utils.findRequiredViewAsType(source, R.id.disconnected, "field 'disconnected'", TextView.class);
    target.swipeContainer = Utils.findRequiredViewAsType(source, R.id.swipeContainer, "field 'swipeContainer'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListFilmsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvListFilms = null;
    target.disconnected = null;
    target.swipeContainer = null;
  }
}
