package dam.isi.frsf.utn.edu.ar.laboratorio04.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.DepartamentoAdapter;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Ciudad;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.BusquedaFinalizadaListener;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.FormBusqueda;

/**
 * Created by martdominguez on 22/09/2016.
 */
public class BuscarDepartamentosTask extends AsyncTask<FormBusqueda,Integer,List<Departamento>> {

    private BusquedaFinalizadaListener<Departamento> listener;

    public BuscarDepartamentosTask(BusquedaFinalizadaListener<Departamento> dListener){
        this.listener = dListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

            }

    @Override
    protected void onPostExecute(List<Departamento> departamentos) {
        super.onPostExecute(departamentos);
        listener.busquedaActualizada("Finalizada");
        listener.busquedaFinalizada(departamentos);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        listener.busquedaActualizada("departamento "+values[0]);


    }

    @Override
    protected List<Departamento> doInBackground(FormBusqueda... busqueda) {
        List<Departamento> todos = Departamento.getAlojamientosDisponibles();
        List<Departamento> resultado = new ArrayList<Departamento>();
        int contador = 0;
        Ciudad ciudadBuscada = busqueda[0].getCiudad();
        double preciomin=busqueda[0].getPrecioMinimo();
        double preciomax=busqueda[0].getPrecioMaximo();
        int huespedes=busqueda[0].getHuespedes();


        // TODO implementar: buscar todos los departamentos del sistema e ir chequeando las condiciones 1 a 1.
        // si cumplen las condiciones agregarlo a los resultados.

            ;
        for(int h=0; h<todos.size();h++){
           if ((todos.get(h).getPrecio()>=preciomin) && (todos.get(h).getPrecio()<=preciomax) /*&& (todos.get(h).getCiudad().getId()==ciudadBuscada.getId())*/&& (todos.get(h).getCantidadCamas()>=huespedes)){
               resultado.add(todos.get(h));
        }
            publishProgress(h);
        }

        return resultado;
    }
}
