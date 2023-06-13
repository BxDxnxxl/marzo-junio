using Microsoft.AspNetCore.Mvc;
using TiendaApi.Datos;
using TiendaApi.Modelo;

namespace TiendaApi.Controllers
{
    [ApiController]
    [Route("api/productos")]
    public class ProductosController:ControllerBase
    {
        [HttpGet]
        public async Task <ActionResult<List<Mproductos>>> Get()
        {
            var funcion = new Dproductos();
            var lista = await funcion.MostrarProductos();
            return lista;
        }
        [HttpPost]
        public async Task Post([FromBody] Mproductos parametros)
        {
            var funcion = new Dproductos();
            await funcion.InsertarProductos(parametros);
        }

        [HttpPut("id")]
        public async Task<ActionResult> Put(int id)
        {
            var funcion = new Dproductos(); 
            parametros.id= id;
            await funcion.EditarProductos(parametros);
            return NoContent();
        }
        
        [HttpDelete("id")]
        public async Task<ActionResult> Delete(int id, [FromBody] Mproductos parametros)
        {
            var funcion = new Dproductos();
            parametros.id = id;
            await funcion.EliminarProductos(parametros);
            return NoContent();
        }
    }
}
