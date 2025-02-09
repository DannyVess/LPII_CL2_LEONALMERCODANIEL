package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProveedorcl2;
import model.TblProveedorcl2;

public class ClassProveedorcl2Imp implements IProveedorcl2 {

	public void RegistrarProveedorcl2(TblProveedorcl2 tblproveedor) {
		//establecemos conexion con la unidad de persistencia...
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_LEONALMERCODANIEL");
			//permite gestionar entidades..
			EntityManager em=emf.createEntityManager();
			//iniciamos la transaccion
			em.getTransaction().begin();
			//registramos
			em.persist(tblproveedor);
			//emitimos mensaje por pantalla....
			System.out.println("Producto registrado en BD correctamente!!!!!!!!");
			//confirmamos
			em.getTransaction().commit();
			//cerramos la transaccion...
			em.close();

	}

	public void ActualizarProveedorcl2(TblProveedorcl2 tblproveedor) {
		// nos conectamos con la unidad de persistencia...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_LEONALMERCODANIEL");
				EntityManager em=emf.createEntityManager();
				//iniciamos la transaccion...
				em.getTransaction().begin();
				//actualizamos
				em.merge(tblproveedor);
				//emitimos mensaje por consola
				System.out.println("datos actualizado correctamente ");
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();

	}

	public void EliminarProveedorcl2(TblProveedorcl2 tblproveedor) {
		///establecemos conexion con la unidad de persistencia...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_LEONALMERCODANIEL");
				//gestionamos las entidades...
				EntityManager em=emf.createEntityManager();
				//iniciamos la transaccion...
				em.getTransaction().begin();
				//recuperar el codigo a eliminar...
				TblProveedorcl2 tblprod=em.merge(tblproveedor);
				//procedemos a eliminar
				em.remove(tblprod);
				System.out.println("dato eliminado");
				em.getTransaction().commit();
				em.close();	

	}

	public List<TblProveedorcl2> ListadoProveedorcl2() {
		//establecemos conexion con la unidad de persistencia...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_LEONALMERCODANIEL");
				//gestionamos las entidades...
				EntityManager em=emf.createEntityManager();
				//iniciamos la transaccion...
				em.getTransaction().begin();
				//recuperamos el listado de la base de datos..
				List<TblProveedorcl2> listadoproductos=em.createQuery("select p from TBL_PROVEEDORCL2 p",TblProveedorcl2.class).getResultList();
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();
				//retornamos el listado...
				return listadoproductos;
	}

	public TblProveedorcl2 BuscarProveedorcl2(TblProveedorcl2 tblproveedor) {
		// establecemos conexion con la unidad de persistencia...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
				//para administrar la transacciones
				EntityManager em=emf.createEntityManager();
				//iniciamos la transaccion...
				em.getTransaction().begin();
				//recuperamos el codigo a buscar...
				TblProveedorcl2 tblprod=em.find(TblProveedorcl2.class,tblproveedor.getIdprooveedorcl2());
				//confirmamos la transaccion
				em.getTransaction().commit();
				//cerramos la transaccion.
				em.close();
				//retornamos el registro solicitado..
				return tblprod;
	}

}
