// Consulta 1 para mostrar todos los documentos de la colección articulos
db.articulos.find()


//Consulta 2 (muestra artículos de categoría Informática, mostrando de estos artículos el código, la denominación y la categoría)
db.articulos.find(
    { categoría: "Informática" },
    { código: 1, denominación: 1, categoría: 1 }
)


// Consulta 2B.
db.articulos.aggregate([
    { $match: { categoría: "Informática" } }, // match filtra los documentos ("Solo quiero los de Informática")
    { $project: { código: 1, denominación: 1, categoría: 1 } } // project muestra los campos que queremos
])


// Consulta 3 (Ordena pvp de forma descendente y ascendente (-1, 1). mostrando todo -menos unidades vendidas y stock)
db.articulos.find(
    {},
    { uv: 0, stock: 0 }
).sort({ pvp: -1 })

db.articulos.find(
    {},
    { uv: 0, stock: 0 }
).sort({ pvp: 1 })


// Consulta 4 (Muestra los artículos con pvp menor a 100)
db.articulos.find(
    { pvp: { $lt: 100 } }
)


// Consulta 5 (Muestra los artículos con stock entre 10 y 20 (inclusive))
db.articulos.find(
    { stock: { $gte: 10, $lte: 20 } }
)



// Consulta 5B (Muestra los artículos con stock entre 10 y 20 (inclusive) ordenados por unidades vendidas y sin mostrar el pvp)
db.articulos.find(
    { stock: { $gte: 10, $lte: 20 } },
    { pvp: 0 }
).sort({ uv: 1 })


// Consulta 6