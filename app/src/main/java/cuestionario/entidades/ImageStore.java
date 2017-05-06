package cuestionario.entidades;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Hector on 06/05/2017.
 */

public class ImageStore implements Serializable {
    private Bitmap beneficiario;
    private Bitmap firma;
    private Bitmap ine;
    private Bitmap inicio;

    public Bitmap getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Bitmap beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Bitmap getFirma() {
        return firma;
    }

    public void setFirma(Bitmap firma) {
        this.firma = firma;
    }

    public Bitmap getIne() {
        return ine;
    }

    public void setIne(Bitmap ine) {
        this.ine = ine;
    }

    public Bitmap getInicio() {
        return inicio;
    }

    public void setInicio(Bitmap inicio) {
        this.inicio = inicio;
    }
}
