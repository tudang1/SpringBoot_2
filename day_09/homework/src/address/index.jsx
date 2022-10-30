import React from "react";
import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";

function Address(){
    const [province,setProvince] = useState([]);
    const [district,setDistrict] = useState([]);
    const [wards, setWards] = useState([]);

    useEffect (()=>{
        const fetchProvinces = async ()=>{
            try {
                let res = await axios.get("https://provinces.open-api.vn/api/p/");
                setProvince(res.data);

            }catch(error){
                console.log(error);
            }
        }

        fetchProvinces();
    },[]);

    const fetchDistricts = async(provinceCode) =>{
        try {
            let res = await axios.get(`https://provinces.open-api.vn/api/p/${provinceCode}?depth=2`);
            
            setDistrict(res.data.districts);
            setWards([]);
        }catch(error){
            console.log(error);
        }
    };

    const fetchWards = async(districtCode) =>{
        try {
            let res = await axios.get(`https://provinces.open-api.vn/api/d/${districtCode}?depth=2`);
            console.log(res);
            setWards(res.data.wards);

        }catch(error){
            console.log(error);
        }
    }

    return (
        <div className="p-4">
            <h2>Danh sách tỉnh thành phố</h2>
            <select id="province" onChange={e => fetchDistricts(e.target.value)}>
                <option hidden>--chọn tỉnh/tp</option>
                {province.map((p)=>(
                    <option value={p.code} key={p.code}>{p.name}</option>
                ))}
            </select>
                
            <select id="district" onChange={e =>fetchWards(e.target.value)}>
                <option hidden>--chọn Quận/ Huyện</option>
                {district.map((p)=>(
                    <option value={p.code} key={p.code}>{p.name}</option>
                ))}
            </select>
                
            <select id="commune">
                <option hidden>--chọn xã</option>
                {wards.map((p)=>(
                    <option value={p.code} key={p.code}>{p.name}</option>
                ))}
            </select>
                

        </div>
    )
}

export default Address;