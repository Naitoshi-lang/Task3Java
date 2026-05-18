const bankAccount = {
    balance: 1250,

    // Вызывается при Number(account) или математических операциях
    valueOf() {
        return this.balance;
    },

    // Вызывается при String(account) или конкатенации со строкой
    toString() {
        return "Balance: " + this.balance;
    }
};

// Проверка
console.log(Number(bankAccount));     // 1250
console.log(String(bankAccount));     // Balance: 1250

// Неявные преобразования
console.log(+bankAccount);            // 1250 (унарный плюс вызывает valueOf)
console.log(bankAccount + " долларов"); // Balance: 1250 долларов (вызов toString)
console.log(bankAccount + 100);       // Balance: 1250100? — Внимание!
