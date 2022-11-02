import React from "react";

function BillInformation(){
    return(
        <div class="col-md-4">
            <div class="bill">
              <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span class="text-black-50">Tạm tính:</span>
                <span class="text-primary" id="sub-total-money">
                  1.200.000 VND
                </span>
              </div>
              <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span class="text-black-50">VAT (10%):</span>
                <span class="text-primary" id="vat-money">
                  120.000 VND
                </span>
              </div>
              <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                <span class="text-black-50">Thành tiền:</span>
                <span class="text-primary" id="total-money">
                  1.320.000 VND
                </span>
              </div>
            </div>
        </div>
    )
}
export default BillInformation;