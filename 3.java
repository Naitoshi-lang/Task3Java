// Создаём уникальный Symbol для скрытого свойства id
const idSymbol = Symbol("id");

const hero = {
    name: "Громобой",        // публичное свойство
    [idSymbol]: "HERO-007"   // скрытое свойство (не видно в обычном переборе)
};

// Метод для получения id
hero.getId = function() {
    return this[idSymbol];
};

// Проверка
console.log(hero.name);           // Громобой — публичное свойство
console.log(hero.getId());        // HERO-007 — получаем скрытый id

// Скрытое свойство не появляется в обычном переборе
for (let key in hero) {
    console.log(key);             // name, getId (Symbol не выводится)
}

console.log(Object.keys(hero));   // ["name", "getId"] — Symbol не попал
console.log(hero[idSymbol]);      // HERO-007 — но его можно получить, если знать Symbol
