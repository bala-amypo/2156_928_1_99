import org.springframework.transaction.annotation.Transactional;

@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Autowired
    private AssetDisposalRepository disposalRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public AssetDisposal createDisposal(Long userId, AssetDisposal disposalRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        disposalRequest.setUser(user);
        disposalRequest.setStatus("PENDING");

        return disposalRepository.save(disposalRequest);
    }

    @Override
    @Transactional
    public AssetDisposal updateDisposalStatus(Long disposalId, String status) {
        AssetDisposal disposal = disposalRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Disposal not found"));

        disposal.setStatus(status);
        return disposalRepository.save(disposal);
    }
}
