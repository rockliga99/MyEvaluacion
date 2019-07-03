package facci.pm.cedenoduenas.myevaluacion;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Nombre, Categoria, Protagonista, Anio, NumeroT , id;
    private Button guardar, leer, leerT, actualizar, Eliminar, eliminarT;
    private TextView Datos;
    private Series dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText)findViewById(R.id.Inombre);
        Categoria = (EditText)findViewById(R.id.Icategoria);
        Protagonista = (EditText)findViewById(R.id.Iprotagonista);
        Anio = (EditText)findViewById(R.id.Ianio);
        NumeroT = (EditText)findViewById(R.id.InumeroT);
        id = (EditText)findViewById(R.id.Id);
        guardar = (Button)findViewById(R.id.Guardar);
        leerT = (Button)findViewById(R.id.LeerT);
        actualizar = (Button)findViewById(R.id.Actualizar);
        eliminarT = (Button)findViewById(R.id.EliminarT);


        guardar.setOnClickListener(this);
        leerT.setOnClickListener(this);

        actualizar.setOnClickListener(this);
        eliminarT.setOnClickListener(this);
        Datos = (TextView)findViewById(R.id.Datos);
        dataBase = new Series(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Guardar:

                if (Nombre.getText().toString().isEmpty()){

                }else if(Nombre.getText().toString().isEmpty()){

                }else if(Categoria.getText().toString().isEmpty()){

                }else if (Protagonista.getText().toString().isEmpty()){

                }else if(Anio.getText().toString().isEmpty()){

                }else if(NumeroT.getText().toString().isEmpty()){

                }else {
                    dataBase.Insertar(Nombre.getText().toString(), Categoria.getText().toString(),
                            Protagonista.getText().toString(), Anio.getText().toString(), NumeroT.getText().toString());
                    Toast.makeText(this, "GUARDADO", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    Nombre.setText("");
                    Categoria.setText("");
                    Protagonista.setText("");
                    Anio.setText("");
                    NumeroT.setText("");
                    Datos.setText("");
                }

                break;

            case R.id.LeerT:
                Datos.setText(dataBase.LeerTodos());
                id.setText("");
                Nombre.setText("");
                Categoria.setText("");
                Protagonista.setText("");
                Anio.setText("");
                NumeroT.setText("");
                Toast.makeText(this, "LISTADOS", Toast.LENGTH_SHORT).show();
                break;


            case R.id.Actualizar:
                if (Nombre.getText().toString().isEmpty()){

                }else if(Nombre.getText().toString().isEmpty()){

                }else if(Categoria.getText().toString().isEmpty()){

                }else if (Protagonista.getText().toString().isEmpty()){

                }else if(Anio.getText().toString().isEmpty()){

                }else if(NumeroT.getText().toString().isEmpty()){

                }else if(id.getText().toString().isEmpty()){

                }else {
                    dataBase.Actualizar(id.getText().toString(), Nombre.getText().toString(), Categoria.getText().toString(),
                            Protagonista.getText().toString(), Anio.getText().toString(), NumeroT.getText().toString());
                    Toast.makeText(this, "ACTUALIZADO", Toast.LENGTH_SHORT).show();
                    id.setText("");
                    Nombre.setText("");
                    Categoria.setText("");
                    Protagonista.setText("");
                    Anio.setText("");
                    NumeroT.setText("");
                    Datos.setText("");
                }
                break;

            case R.id.EliminarT:
                dataBase.EliminarTodo();
                Datos.setText("");
                Toast.makeText(this, "ELIMINADOS", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
