package command;

public interface Command {
    
	//za svaki oblik posabna klasa koja se bavi undo i redo funkc
	
	void execute(); //izvrsavanje dodavanja
	void unexecute(); //ponistavanje(brisanje dodatog)
}
