package agenda.interfaces;

import agenda.model.Contato;
import java.util.List;

public interface IContato {
    
    int adicionarContato(Contato contato);    
    Contato buscarContatoPorId(int contatoId);    
    List<Contato> buscarTodosContatos();    
    int atualizarContato(Contato contato);    
    int deletarContato(Contato contato);
    
}
