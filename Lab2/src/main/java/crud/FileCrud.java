package crud;

import entity.Entity;
import fileIO.FileIO;
import fileIO.FileIOInterface;

public class FileCrud implements Lab2CrudInterface {
	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public Entity readEntity() {
		// TODO Auto-generated method stub
		return (Entity)fio.loadFromFile();
	}

	@Override
	public void updateEntity(Entity entity) {
		// TODO Auto-generated method stub
		fio.saveToFile(entity);

	}
}
