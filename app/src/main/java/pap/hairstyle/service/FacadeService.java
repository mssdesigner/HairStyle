package pap.hairstyle.service;

/**
 * Created by vinicius on 02/11/16.
 */

public class FacadeService {

    private CabelereiroService cs;
    private ClienteService clienteS;
    private ServicoService ss;
    private TelefoneService ts;

    public FacadeService(){
        cs = new CabelereiroService();
        clienteS = new ClienteService();
        ss = new ServicoService();
        ts = new TelefoneService();
    }

    public CabelereiroService getCs() {
        return cs;
    }

    public void setCs(CabelereiroService cs) {
        this.cs = cs;
    }

    public ClienteService getClienteS() {
        return clienteS;
    }

    public void setClienteS(ClienteService clienteS) {
        this.clienteS = clienteS;
    }

    public ServicoService getSs() {
        return ss;
    }

    public void setSs(ServicoService ss) {
        this.ss = ss;
    }

    public TelefoneService getTs() {
        return ts;
    }

    public void setTs(TelefoneService ts) {
        this.ts = ts;
    }
}
