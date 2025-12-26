package com.example.demo.service;

import com.example.demo.entity.AssetDisposal;
import java.util.List;

public interface AssetDisposalService {

    AssetDisposal createDisposal(AssetDisposal disposal);

    List<AssetDisposal> getAllDisposals();
}
