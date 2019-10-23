// Generated code from Butter Knife. Do not modify!
package com.example.yhernandez.directorio.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.yhernandez.directorio.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ItemAdapter_ViewBinding implements Unbinder {
  private ItemAdapter target;

  @UiThread
  public ItemAdapter_ViewBinding(ItemAdapter target, View source) {
    this.target = target;

    target.ivImagen = Utils.findRequiredViewAsType(source, R.id.ivImagen, "field 'ivImagen'", CircleImageView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.tvDetails = Utils.findRequiredViewAsType(source, R.id.tvDetails, "field 'tvDetails'", TextView.class);
    target.tvEvalua = Utils.findRequiredViewAsType(source, R.id.tvEvalua, "field 'tvEvalua'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ItemAdapter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivImagen = null;
    target.title = null;
    target.tvDetails = null;
    target.tvEvalua = null;
  }
}
