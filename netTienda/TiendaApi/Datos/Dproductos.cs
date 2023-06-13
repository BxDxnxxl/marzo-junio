using Microsoft.VisualBasic;
using System.Data;
using System.Data.SqlClient;
using TiendaApi.conexion;
using TiendaApi.Modelo;
namespace TiendaApi.Datos
{
    public class Dproductos
    {
        Conexionbd cn = new Conexionbd();
        
        public async Task <List<Mproductos>> MostrarProductos()
        {
            var lista =new List<Mproductos>();
            using (var sql = new SqlConnection(cn.cadenaSQL()))
            {
                using (var cmd = new SqlCommand("VerProductos", sql))
                {
                    await sql.OpenAsync();
                    cmd.CommandType = CommandType.StoredProcedure;
                    using (var item = await cmd.ExecuteReaderAsync()) 
                    {
                        while (await item.ReadAsync())
                        {
                            var mproductos = new Mproductos();
                            mproductos.precio = (double)item["precio"];
                            mproductos.descripcion = (string)item["descripcion"];
                            lista.Add(mproductos);
                        }
                        {
                            
                        }
                    }
                }

            }
            return lista;
        }
        public async Task InsertarProductos(Mproductos parametros)
        {
            using (var sql = new SqlConnection(cn.cadenaSQL()))
            {
                using (var cmd = new SqlCommand("InsertarProductos", sql))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@descripcion", parametros.descripcion);
                    cmd.Parameters.AddWithValue("@precio", parametros.precio);
                    await sql.OpenAsync();
                    await cmd.ExecuteReaderAsync();
                }
                }
            
        }
        public async Task EditarProductos(Mproductos parametros)
        {
            using (var sql = new SqlConnection(cn.cadenaSQL()))
            {
                using (var cmd = new SqlCommand("InsertarProductos", sql))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@descripcion", parametros.descripcion);
                    cmd.Parameters.AddWithValue("@descripcion", parametros.id);
                    cmd.Parameters.AddWithValue("@precio", parametros.precio);
                    await sql.OpenAsync();
                    await cmd.ExecuteReaderAsync();
                }
            }

        }
        public async Task EliminarProductos(Mproductos parametros)
        {
            using (var sql = new SqlConnection(cn.cadenaSQL()))
            {
                using (var cmd = new SqlCommand("InsertarProductos", sql))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@descripcion", parametros.id);
                    await sql.OpenAsync();
                    await cmd.ExecuteReaderAsync();
                }
            }

        }
    }
}
