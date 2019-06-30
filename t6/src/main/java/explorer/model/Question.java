import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.*;

public class Question{
  private SimpleStringProperty ano, prova, tipoquestao, idquestao, objeto, objetodetalhado, acertoscurso, acertosregiao, acertosbrasil, acertosdif, gabarito, urlcrop;

  public Question(String ano, String prova,String tipoquestao,String idquestao,String objeto,String objetodetalhado,String acertoscurso,String acertosregiao,String acertosbrasil,String acertosdif, String gabarito, String urlcrop){
    this.ano = new SimpleStringProperty(ano);
    this.prova = new SimpleStringProperty(prova);
    this.tipoquestao = new SimpleStringProperty(tipoquestao);
    this.idquestao = new SimpleStringProperty(idquestao);
    this.objeto = new SimpleStringProperty(objeto);
    this.objetodetalhado = new SimpleStringProperty(objetodetalhado);
    this.acertoscurso = new SimpleStringProperty(acertoscurso);
    this.acertosregiao = new SimpleStringProperty(acertosregiao);
    this.acertosbrasil = new SimpleStringProperty(acertosbrasil);
    this.acertosdif = new SimpleStringProperty(acertosdif);
    this.gabarito = new SimpleStringProperty(gabarito);
    this.urlcrop = new SimpleStringProperty(urlcrop);
  }

  public String getAno(){
    return ano.get();
  }

  public void setAno(String ano){
    this.ano.set(ano);
  }

  public StringProperty anoProperty() {
    return ano;
  }

  public String getProva(){
    return prova.get();
  }

  public void setProva(String prova){
    this.prova.set(prova);
  }

  public StringProperty provaProperty() {
        return prova;
  }

  public String getTipoquestao(){
    return tipoquestao.get();
  }

  public void setTipoquestao(String tipoquestao){
    this.tipoquestao.set(tipoquestao);
  }

  public StringProperty tipoquestaoProperty() {
        return tipoquestao;
  }

  public String getIdquestao(){
    return idquestao.get();
  }

  public void setIdquestao(String idquestao){
    this.idquestao.set(idquestao);
  }

  public StringProperty idquestaoProperty() {
        return idquestao;
  }

  public String getObjeto(){
    return objeto.get();
  }

  public void setObjeto(String objeto){
    this.objeto.set(objeto);
  }

  public StringProperty objetoProperty() {
        return objeto;
  }

  public String getObjetodetalhado(){
    return objetodetalhado.get();
  }

  public void setObjetodetalhado(String objetodetalhado){
    this.objetodetalhado.set(objetodetalhado);
  }

  public StringProperty objetodetalhadoProperty() {
        return objetodetalhado;
  }

  public String getAcertoscurso(){
    return acertoscurso.get();
  }

  public void setAcertoscurso(String acertoscurso){
    this.acertoscurso.set(acertoscurso);
  }

  public StringProperty acertoscursoProperty() {
        return acertoscurso;
  }

  public String getAcertosregiao(){
    return acertosregiao.get();
  }

  public void setAcertosregiao(String acertosregiao){
    this.acertosregiao.set(acertosregiao);
  }

  public StringProperty acertosregiaoProperty() {
        return acertosregiao;
  }

  public String getAcertosbrasil(){
    return acertosbrasil.get();
  }

  public void setAcertosbrasil(String acertosbrasil){
    this.acertosbrasil.set(acertosbrasil);
  }

  public StringProperty acertosbrasilProperty() {
    return acertosbrasil;
  }

  public String getAcertosdif(){
    return acertosdif.get();
  }

  public void setAcertosdif(String acertosdif){
    this.acertosdif.set(acertosdif);
  }

  public StringProperty acertosdifProperty() {
        return acertosdif;
  }

  public String getGabarito(){
    return gabarito.get();
  }

  public void setGabarito(String gabarito){
    this.gabarito.set(gabarito);
  }

  public StringProperty gabaritoProperty() {
        return gabarito;
  }

  public String getUrlcrop(){
    return urlcrop.get();
  }

  public void setUrlcrop(String urlcrop){
    this.urlcrop.set(urlcrop);
  }

  public StringProperty urlcropProperty() {
        return urlcrop;
  }
}
