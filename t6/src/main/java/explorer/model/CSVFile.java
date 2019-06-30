import com.opencsv.bean.CsvBindByName;

public class CSVFile{
  @CsvBindByName
  private String ano;
  @CsvBindByName
  private String prova;
  @CsvBindByName
  private String tipoquestao;
  @CsvBindByName
  private String idquestao;
  @CsvBindByName
  private String objeto;
  @CsvBindByName
  private String objetodetalhado;
  @CsvBindByName
  private String gabarito;
  @CsvBindByName
  private String acertoscurso;
  @CsvBindByName
  private String acertosregiao;
  @CsvBindByName
  private String acertosbrasil;
  @CsvBindByName
  private String acertosdif;
  @CsvBindByName
  private String urlcrop;

	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getProva() {
		return prova;
	}
  public void setProva(String prova) {
		this.prova = prova;
	}

  public String getTipoquestao() {
		return tipoquestao;
	}
	public void setTipoquestao(String tipoquestao) {
		this.tipoquestao = tipoquestao;
	}

  public String getIdquestao() {
		return idquestao;
	}
	public void setIdquestao(String idquestao) {
		this.idquestao = idquestao;
	}

	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getObjetodetalhado() {
		return objetodetalhado;
	}
	public void setObjetodetalhado(String objetodetalhado) {
		this.objetodetalhado = objetodetalhado;
	}

	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}

	public String getAcertoscurso() {
		return acertoscurso;
	}
	public void setAcertoscurso(String acertoscurso) {
		this.acertoscurso = acertoscurso;
	}

	public String getAcertosregiao() {
		return acertosregiao;
	}
	public void setAcertosregiao(String acertosregiao) {
		this.acertosregiao = acertosregiao;
	}

	public String getAcertosbrasil() {
		return acertosbrasil;
	}
	public void setAcertosbrasil(String acertosbrasil) {
		this.acertosbrasil = acertosbrasil;
	}

	public String getAcertosdif() {
		return acertosdif;
	}
	public void setAcertosdif(String acertosdif) {
		this.acertosdif = acertosdif;
	}

  public String getUrlcrop() {
    return urlcrop;
  }
  public void setUrlcrop(String urlcrop) {
    this.urlcrop = urlcrop;
  }
}
