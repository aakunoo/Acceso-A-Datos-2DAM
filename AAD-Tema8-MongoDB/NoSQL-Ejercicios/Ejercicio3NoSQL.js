// Ejercicio 3 NOSQL

// 2. Crea una base de datos llamada mibasedatos. Dentro de ella una colección llamada alumnos. 
// Cada alumno tendrá los campos: nombre, teléfono, curso y nota. 
// Inserta 3 alumnos en cada uno de los cursos: 1DAM, 2DAM, 1ASIR y 2ASIR.

db.alumnos.insertOne(
  {
	nombre: "Jeronimo",
	telefono: 622468102,
	curso: "2º DAM",
	nota: 7
}
)

db.alumnos.insertMany([
  { nombre: "Zurron", telefono: "123456789", curso: "2DAM", nota: 5 },
  { nombre: "Chema", telefono: "333444555", curso: "2DAM", nota: 8 },
  { nombre: "Carlos", telefono: "333333333", curso: "1DAM", nota: 4 },
  { nombre: "Luis", telefono: "555555555", curso: "1DAM", nota: 8 },
  { nombre: "Marta", telefono: "666666666", curso: "1DAM", nota: 7 },
  { nombre: "Raúl", telefono: "777777777", curso: "1ASIR", nota: 5 },
  { nombre: "Lucía", telefono: "888888888", curso: "1ASIR", nota: 6 },
  { nombre: "Andrés", telefono: "999999999", curso: "1ASIR", nota: 7 },
  { nombre: "Jorge", telefono: "121212121", curso: "2ASIR", nota: 5 },
  { nombre: "Sofía", telefono: "131313131", curso: "2ASIR", nota: 2 },
  { nombre: "Elena", telefono: "141414141", curso: "2ASIR", nota: 7 }
])


// 3. Añade edad a todos los alumnos

db.alumnos.updateMany(
  {},
  {$set: {edad: 20}} // Les asigno 20, no sé cómo hacerlo aleatorio.
)

// 4. Sube la nota 1 punto a todos los alumnos de 1DAM y bájale 2 puntos a todos los de 2ASIR

db.alumnos.updateMany(
  {curso: "1DAM"},
  {$inc: {nota: 1}}
)

db.alumnos.updateMany(
  {curso: "2ASIR"},
  {$inc: {nota: -2}}
)

// 5. Añade la población Salamanca a todos los de DAM y la población Zamora a todos los de ASIR

db.alumnos.updateMany(
  {curso: {$in: ["1DAM", "2DAM"]}},
  {$set: {poblacion: "Salamanca"}}
)

db.alumnos.updateMany(
  {curso: {$in: ["1ASIR", "2ASIR"]}},
  {$set: {poblacion: "Zamora"}}
)

// 6. Añade la colección de empleados a la base de datos mibasedatos

db.empleados.insertMany([
  { NumEmp: 1, nombre: "Luis", dep: 10, salario: 1000, fechaalta: "10/12/1998" },
  { NumEmp: 2, nombre: "Luisa", dep: 10, salario: 1400, fechaalta: "18/10/1999", oficio: "profesora" },
  { NumEmp: 3, nombre: "Patricia", dep: 20, salario: 1500, fechaalta: "10/12/1998", oficio: "analista", comision: 100 },
  { NumEmp: 4, nombre: "Roberto", dep: 20, salario: 1100, fechaalta: "18/01/2001" },
  { NumEmp: 5, nombre: "Marcos", dep: 30, salario: 1400, fechaalta: "10/11/1999", comision: 200, oficio: "Analista" }
])

// 7. Visualiza el resultado de:
	// Empleados del departamento 10
	// Empleados del departamento 10 y 20
	// Empleados con salario mayor a 1300 y oficio profesora

db.empleados.find(
  {dep: 10}
)


db.empleados.find(
  {dep: {$in: [10,20]}}
)


db.empleados.find(
{ 
salario: { $gt: 1300 }, 
oficio: "profesora" 
}
)

// 8. Sube el salario a todos los analistas en 100 euros.

db.empleados.updateMany(
  {oficio: {$regex: /analista/i}}, // regex filtra los documentos, en este caso, que coincidan con analista. /i es para ignorar mayúsculas y minúsculas.
  {$inc: {salario: 100}}
)


// 9. Decrementa la comisión en 20 euros a todos los que la tengan.

db.empleados.updateMany(
  { comision: { $exists: true } }, // Si la comision existe, comision -20.
  { $inc: { comision: -20 } }
)