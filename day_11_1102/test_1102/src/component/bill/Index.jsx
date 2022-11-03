import React from "react";
import { useState } from "react";

function BillInformation({onItems}){
    const total = onItems.map((item)=>{
      return item.price * item.count
    })
    const subTotal = total.reduce((prev, next) => prev + next);
    return(
      // console.log(subTotal)
        <div className="col-md-4">
            <div className="bill">
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Tạm tính:</span>
                <span className="text-primary" id="sub-total-money">
                  {subTotal +" VND"}
                </span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">VAT (10%):</span>
                <span className="text-primary" id="vat-money">
                  {subTotal/10 + " VND" }
                </span>
              </div>
              <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span className="text-black-50">Thành tiền:</span>
                <span className="text-primary" id="total-money">
                  {subTotal + subTotal/10 +" VND" }
                </span>
              </div>
            </div>
        </div>
    )
}
export default BillInformation;