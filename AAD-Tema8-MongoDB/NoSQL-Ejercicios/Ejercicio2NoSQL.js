// Mostrar por línea de comandos que se han importando correctamente todos los datos en un formato más legible, y muestras el número documentos
db.libros.find().pretty()

db.libros.find().pretty().count() 

// Consulta 2 -> Visualiza los libros de la editorial Garceta, con PVP entre 20 y 40 incluidos y que no tengan el tema SOCKET.
db.libros.find(
  {
    editorial: "Garceta",
    pvp: { $gte: 20, $lte: 40 },
    temas: { $ne: "SOCKET" }
  }
)


// Consulta 3 -> Agregar codigoPaises: 1 a los que no lo tengan y que su pvp sea < 40.
// Comprobación antes: db.libros.find({ pvp: { $lt: 40 }, codigoPais: 1 }).pretty()

db.libros.updateMany(
  {pvp: {$lt: 40}, codigosPaises: {$ne: 1} },
  {$push: {codigosPaises: 1}}
)


// Consulta 4 -> A los libros con pvp entre 30-50 y sin tema Windows y SQL, agregar codigoPaises 127,129.

db.libros.updateMany(
  {pvp: {$gte: 30, $lte: 50}, temas: {$nin: ["Windows", "SQL"]}},
  {$addToSet: {codigosPaises: [127, 129]}}
)


// Consulta 5 - > Elimina los países 1 y 34 en los libros de Garceta.

db.libros.updateMany( // con updateMany para no afectar al resto del documento.
  {editorial: "Garceta"},
  {$pull: {codigosPaises: [1, 34]}} // retira del array codigos: 1 y 34.
)


// Consulta 6 -> Elimina los documentos de los libros de Garceta o Anaya que tengan el país 49 o 33.

db.libros.deleteMany(
  {editorial: {$in: ["Garceta", "Anaya"]}, codigosPaises: {$in: [49, 33]}}
)


// Consulta 7 ->  Borra la colección libros
db.libros.drop()