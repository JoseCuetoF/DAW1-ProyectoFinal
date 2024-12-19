/**
 * MODAL PARA EL BOTON ACTUALIZAR
 * */
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('btnUpdate').addEventListener('click', function () {
        Swal.fire({
            /*title: '¿Estás seguro?',*/
            text: "Los cambios se guardarán permanentemente.",
            /*
            icon: 'warning',
            iconColor: '#0070c1',*/
            imageUrl: '/img/Consulta.png',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, actualizar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                document.getElementById("formUpdate").submit();
            }
        });
    });
});


/**
 * MODAL PARA EL BOTON ELIMINAR
 * */
document.addEventListener('DOMContentLoaded', function () {
    // Selecciona todos los botones de eliminar
    const deleteButtons = document.querySelectorAll('.delete-btn');

    deleteButtons.forEach(button => {
        button.addEventListener('click', function (event) {
            event.preventDefault(); // Previene la acción predeterminada del enlace

            // Obtén la URL y el ID desde los atributos
            const url = button.getAttribute('data-url');
            const id = button.getAttribute('data-id'); // Obtener valor dinámico de data-id

            // Muestra el modal de confirmación
            Swal.fire({
                title: '¿Estás seguro?',
                text: `No podrás revertir esta acción. Se eliminará el registro con ID: ${id}.`,
                icon: 'warning',
                iconColor: '#d33',
                showCancelButton: true,
                confirmButtonColor: '#d33',
                cancelButtonColor: '#3085d6',
                confirmButtonText: 'Sí, eliminar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    // redirigir a la pagina despues del eliminado
                    window.location.href = url;
                }
            });
        });
    });
});

/**
 * Modal para el botón agregar categoria
 * */
    document.getElementById('addCategoryBtn').addEventListener('click', function () {
    Swal.fire({
        title: 'Nueva Categoría',
        html: `
                <form id="addCategoryForm" action="/maintenance/addCategory" method="POST">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>
                    <div class="form-group mt-3">
                        <label for="activo">Activo:</label>
                        <select class="form-control" id="activo" name="activo" required>
                            <option value="1">Sí</option>
                            <option value="0">No</option>
                        </select>
                    </div>
                </form>
            `,
        showCancelButton: true,
        confirmButtonText: 'Guardar',
        preConfirm: () => {
            const form = document.getElementById('addCategoryForm');
            form.submit(); // Envía el formulario
        }
    });
});
