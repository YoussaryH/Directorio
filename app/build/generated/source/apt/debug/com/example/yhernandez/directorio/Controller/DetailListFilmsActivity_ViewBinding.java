// Generated code from Butter Knife. Do not modify!
package com.example.yhernandez.directorio.Controller;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.yhernandez.directorio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailListFilmsActivity_ViewBinding implements Unbinder {
  private DetailListFilmsActivity target;

  @UiThread
  public DetailListFilmsActivity_ViewBinding(DetailListFilmsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailListFilmsActivity_ViewBinding(DetailListFilmsActivity target, View source) {
    this.target = target;

    target.ivImagen = Utils.findRequiredViewAsType(source, R.id.ivImagen, "field 'ivImagen'", ImageView.class);
    target.tvTittleMovies = Utils.findRequiredViewAsType(source, R.id.tvTittleMovies, "field 'tvTittleMovies'", TextView.class);
    target.tvDescription = Utils.findRequiredViewAsType(source, R.id.tvDescription, "field 'tvDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailListFilmsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivImagen = null;
    target.tvTittleMovies = null;
    target.tvDescription = null;
  }
}
