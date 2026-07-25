import React,{ useState } from "react";

function CurrencyConverter() {
    const [rupees, setRupees] = useState(0)
    const [euros, setEuros] = useState(0)

    const converstionRate = 0.011; 

    const handleSubmit = (event) => {
        event.preventDefault();
        const newEuros = rupees * converstionRate;
        setEuros(newEuros);
    };

    return (
        <div>
            <h2>Currency Converter</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Rupees:
                    <input
                        type="number"
                        value={rupees}
                        onChange={(e) => setRupees(parseFloat(e.target.value))}
                    />
                </label>
                <button type="submit">Convert</button>
            </form>
            <p>Euros: {euros.toFixed(2)}</p>
        </div>
    )
}

export default CurrencyConverter;