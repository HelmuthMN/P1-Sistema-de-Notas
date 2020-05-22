/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author alema
 */
public class Avaliacao implements IMedia,IPresenca{
    private float mediaFinal;
    private float percentualPresenca;

    public float getMediaFinal() {
        return mediaFinal;
    }

    public float getPercentualPresenca() {
        return percentualPresenca;
    }

    @Override
    public void calcularMedia(float p1, float p2) {
        mediaFinal = (p1 + p2)/2;
    }

    @Override
    public void calcularMedia(float p1, float p2, float p3) {
        mediaFinal = (p1 + p2 + p3)/3;
    }

    @Override
    public void calcularPercentualPresenca(float totalAulas, float qtdePresencas) {
        percentualPresenca = (qtdePresencas / totalAulas)*100;
    }   
}
