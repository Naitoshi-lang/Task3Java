function cloneDeep(obj) {
    // Базовый случай: если не объект или null — возвращаем как есть
    if (obj === null || typeof obj !== "object") {
        return obj;
    }

    // Обработка массивов
    if (Array.isArray(obj)) {
        const clonedArray = [];
        for (let i = 0; i < obj.length; i++) {
            clonedArray[i] = cloneDeep(obj[i]);
        }
        return clonedArray;
    }

    // Обработка обычных объектов
    const clonedObj = {};
    for (let key in obj) {
        // Проверяем, что свойство принадлежит самому объекту, а не прототипу
        if (obj.hasOwnProperty(key)) {
            clonedObj[key] = cloneDeep(obj[key]);
        }
    }
    return clonedObj;
}

// Проверка работы
const original = {
    name: "Легион",
    level: 10,
    stats: {
        strength: 100,
        agility: 80,
        skills: ["удар", "блок", "рывок"]
    },
    isActive: true
};

const copy = cloneDeep(original);

// Изменяем копию — оригинал не должен измениться
copy.stats.strength = 999;
copy.stats.skills.push("суперудар");

console.log(original.stats.strength); // 100 (не изменилось)
console.log(original.stats.skills);   // ["удар", "блок", "рывок"] (не изменилось)
console.log(copy.stats.strength);     // 999
console.log(copy.stats.skills);       // ["удар", "блок", "рывок", "суперудар"]
