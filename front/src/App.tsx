import React, {useEffect}  from 'react'
import { Player } from "./Player"
import axios from 'axios'

let players: Player[] = []

const App: React.VFC = () => {
    const [rows, setRows] = React.useState(players)
    useEffect(() => {
        const getData = async() => {
            const result = await axios(
                'http://localhost:8080/api/players'
            )
            setRows(result.data)
        }
        getData()
    }, [])

    return (
        <>
        <h1>Hoge</h1>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>last name</th>
                    <th>firlst name</th>
                </tr>
            </thead>
            <tbody>
            {rows.map(row => (
                <tr key={row.id}>
                    <td>{row.id}</td>
                    <td>{row.lastName}</td>
                    <td>{row.firstName}</td>
                </tr>
            ))}
            </tbody>
        </table>
     </>
    )
}


export default App