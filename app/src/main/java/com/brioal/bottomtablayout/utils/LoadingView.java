package com.brioal.bottomtablayout.utils;

import android.app.AlertDialog;
import android.content.Context;

import dmax.dialog.SpotsDialog;

/**
 * Created by apple on 16/11/28.
 */

public class LoadingView {
    private AlertDialog mLoadingDialog;

    public LoadingView(Context context, int message) {
        mLoadingDialog = new SpotsDialog(context, message);
    }

    public void show() {
        mLoadingDialog.show();
    }

    public void dismiss() {
        mLoadingDialog.dismiss();
    }


}
