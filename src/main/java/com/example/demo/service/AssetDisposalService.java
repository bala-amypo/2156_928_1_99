package com.example.demo.service;

import com.example.demo.entity.AssetDisposal;

public interface AssetDisposalService {

    AssetDisposal createDisposal(Long userId, AssetDisposal disposalRequest);

    AssetDisposal updateDisposalStatus(Long disposalId, String status);
}
