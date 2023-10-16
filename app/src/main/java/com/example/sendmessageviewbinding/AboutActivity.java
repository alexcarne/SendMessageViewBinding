package com.example.sendmessageviewbinding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
/**
*Clase encargada de generar la activity about as donde se encuentran los datos del creador del proyecto la version y un enlace al  reposistorio de daniel stone.
* Esta clase genera las CARD donde se muestra toda la información mencionada anteriormente.
 */
public class AboutActivity extends MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard.Builder carda = new MaterialAboutCard.Builder();
        MaterialAboutCard.Builder cardb = new MaterialAboutCard.Builder();

        carda.addItem(new MaterialAboutActionItem.Builder()
                .text("Alex Carnero")
                .subText("Al. módulo Deint")
                .icon(R.drawable.baseline_person_2_24)
                .build());
        carda.addItem(new MaterialAboutActionItem.Builder()
                .text("Fork on GitHUB")
                .icon(R.drawable.baseline_screen_share_24)
                .setOnClickAction(new MaterialAboutItemOnClickAction()  {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/daniel-stoneuk/material-about-library/blob/master/"));
                        startActivity(intent);
                    }
                })
                .build());
        cardb.addItem(new MaterialAboutActionItem.Builder()
                .text("Version")
                .subText("1.0.0")
                .icon(R.drawable.info)
                .build());
        return new MaterialAboutList.Builder()
                .addCard(carda.title("autor").build())
                .addCard(cardb.build())
                .build();
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }
}
