/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.wearable.gridviewpager;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OtherSueloFragment extends Fragment {

    private String TAG = "CustomFragment";
    private TextView mTextView__nombre_especie;
    private String mNombreEspecie;
    private String mTipoDeSueloQueNo;
    /**
     * During creation, if arguments have been supplied to the fragment
     * then parse those out.
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mNombreEspecie = (String) args.getCharSequence("nombreEspecie", mNombreEspecie);
            mTipoDeSueloQueNo = (String) args.getCharSequence("tipoDeSuelo", mTipoDeSueloQueNo);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.other_suelo_fragment, container, false);
        View mTextView__nombre_especie  = v.findViewById(R.id.nombreEspecie);
        ((TextView)mTextView__nombre_especie).setText(mNombreEspecie != null ? mNombreEspecie : "(no label)");

        View mImageView__boton_accion_a  = v.findViewById( R.id.boton_tipo_suelo_a);
        View mImageView__boton_accion_b  = v.findViewById( R.id.boton_tipo_suelo_b);

        switch (mTipoDeSueloQueNo) {
            case "suelo-desnudo":
                Log.d(TAG, "No mostrar Suelo desnudo");

                mImageView__boton_accion_a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_toque_directo();
                    }
                });

                mImageView__boton_accion_b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_muerto_en_pie();
                    }
                });

                break;
            case "toque-directo":
                Log.d(TAG, "No mostrar Toque directo");
                mImageView__boton_accion_a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_suelo_desnudo();
                    }
                });

                mImageView__boton_accion_b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_muerto_en_pie();
                    }
                });


                break;
            case "muerto-en-pie":
                Log.d(TAG, "No mostrar Muerto en pie");
                mImageView__boton_accion_a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_suelo_desnudo();
                    }
                });

                mImageView__boton_accion_b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        Log.d(TAG, "click en el boton!!");
                        reaccionar_toque_directo();
                    }
                });


                break;
            default:
                Log.d(TAG, "Error. No se respeta la intergace de args");
                break;
        }
        return v;
    }

    private void reaccionar_muerto_en_pie() {
        Log.d(TAG, "MUERTO EN PIE");
    }

    private void reaccionar_toque_directo() {
        Log.d(TAG, "TOQUE DIRECTO");
    }

    private void reaccionar_suelo_desnudo() {
        Log.d(TAG, "SUELO NAKED");
    }


}
